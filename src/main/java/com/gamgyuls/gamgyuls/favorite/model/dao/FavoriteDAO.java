package com.gamgyuls.gamgyuls.favorite.model.dao;

import com.gamgyuls.gamgyuls.favorite.dto.FavoriteDTO;

import java.util.List;

public interface FavoriteDAO {
    void addFavorite(FavoriteDTO userFavorite);

    // 특정 사용자 즐겨찾기 조회
    List<FavoriteDTO> getFavoriteById(String userFavorite);

    // 모든 즐겨찾기 조회
    List<FavoriteDTO> getAllFavorites();

    // 즐겨찾기 삭제
    void deleteFavorite(String busStopId, String userId);
}
