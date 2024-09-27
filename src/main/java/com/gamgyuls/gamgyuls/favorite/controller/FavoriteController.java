package com.gamgyuls.gamgyuls.favorite.controller;

import com.gamgyuls.gamgyuls.favorite.model.service.FavoriteService;
import com.gamgyuls.gamgyuls.util.JwtUtil;
import io.jsonwebtoken.Claims;
import com.gamgyuls.gamgyuls.favorite.dto.FavoriteDTO;
import com.gamgyuls.gamgyuls.favorite.model.dao.FavoriteDAO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteDAO favoriteDAO;
    private final FavoriteService favoriteService;
    private final JwtUtil jwtUtil; // JwtUtil 클래스 인스턴스

    @Autowired
    public FavoriteController(FavoriteDAO favoriteDAO, FavoriteService favoriteService, JwtUtil jwtUtil) {
        this.favoriteDAO = favoriteDAO;
        this.favoriteService = favoriteService;
        this.jwtUtil = jwtUtil; // 의존성 주입
    }

    // 즐겨찾기 추가
    @PostMapping("/add")
    @Operation(summary = "즐겨찾기 추가", description = "jwt를 활용한 즐겨찾기 추가")
    public ResponseEntity<String> addUserFavorite(@RequestBody FavoriteDTO userFavoriteDTO, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        if (token == null || token.isEmpty()) {
            return new ResponseEntity<>("Authorization header is missing.", HttpStatus.UNAUTHORIZED);
        }

        String jwtToken = token.substring(7);
        Claims claims = jwtUtil.decodeToken(jwtToken);
        String userId = claims.get("sub", String.class);
        System.out.println(userId);
        // userId 세팅
        userFavoriteDTO.setUserId(userId);
        favoriteService.addFavorite(userFavoriteDTO);

        return new ResponseEntity<>("User favorite added successfully.", HttpStatus.CREATED);
    }

    // 특정 정류장 즐겨찾기 조회
    @GetMapping("/getByUserToken")
    @Operation(summary = "즐겨찾기 조회", description = "사용자가 즐겨찾기한 버스 리스트 조회")
    public ResponseEntity<List<FavoriteDTO>> getUserFavoriteById( @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {

        String jwtToken = token.substring(7);
        Claims claims = jwtUtil.decodeToken(jwtToken);
        String userId = claims.get("sub", String.class);

        List<FavoriteDTO> userFavorite = favoriteDAO.getFavoriteById(userId);
        if (userFavorite != null && !userFavorite.isEmpty()) {
            return new ResponseEntity<>(userFavorite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 모든 즐겨찾기 조회
    @GetMapping("/all")
    @Operation(summary = "즐겨찾기 전체 조회", description = "즐겨찾기 DB에 있는 모든 데이터 조회")
    public ResponseEntity<List<FavoriteDTO>> getAllUserFavorites() {
        List<FavoriteDTO> userFavorites = favoriteDAO.getAllFavorites();
        return new ResponseEntity<>(userFavorites, HttpStatus.OK);
    }

    // 즐겨찾기 삭제
    @DeleteMapping("/delete")
    @Operation(summary = "즐겨찾기 삭제", description = "사용자가 즐겨찾기한 버스 리스트 삭제")
    public ResponseEntity<String> deleteUserFavorite(@PathVariable String busStopId, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        String jwtToken = token.substring(7);
        Claims claims = jwtUtil.decodeToken(jwtToken);
        String userId = claims.get("sub", String.class);
        System.out.println("-------------");
        System.out.println(userId);
        favoriteDAO.deleteFavorite(busStopId, userId);
        return new ResponseEntity<>("User favorite deleted successfully.", HttpStatus.OK);
    }
}