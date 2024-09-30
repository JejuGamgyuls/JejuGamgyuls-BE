package com.gamgyuls.gamgyuls.favorite.model.service;

import com.gamgyuls.gamgyuls.favorite.dto.FavoriteDTO;
import com.gamgyuls.gamgyuls.favorite.model.dao.FavoriteDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteDAO favoriteDAO;

    public FavoriteServiceImpl(FavoriteDAO favoriteDAO) {
        this.favoriteDAO = favoriteDAO;
    }

    @Override
    public void addFavorite(FavoriteDTO favorite) {
        favoriteDAO.addFavorite(favorite);
    }

    @Override
    public List<FavoriteDTO> getFavoriteById(String userId) {
        return favoriteDAO.getFavoriteById(userId);
    }

    @Override
    public List<FavoriteDTO> getAllFavorites() {
        return favoriteDAO.getAllFavorites();
    }

    @Override
    public void deleteFavorite(String busStopId,String routeid, String userId) {
         favoriteDAO.deleteFavorite(busStopId, routeid, userId);
    }
}