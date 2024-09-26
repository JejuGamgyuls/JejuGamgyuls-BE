package com.gamgyuls.gamgyuls.favorite.model.service;

import com.gamgyuls.gamgyuls.favorite.dto.FavoriteDTO;

import java.util.List;

public interface FavoriteService {
    // 즐겨찾기 추가
    void addFavorite(FavoriteDTO favorite);

    // 특정 정류장 즐겨찾기 조회
    List<FavoriteDTO> getFavoriteById(String busStopId);

    // 모든 즐겨찾기 조회
    List<FavoriteDTO> getAllFavorites();

    // 즐겨찾기 삭제
    void deleteFavorite(String busStopId, String userId);
}