package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.repository.PlaylistRepository;
import com.kodnest.tunehub.service.PlaylistService;
@Service
public class PlaylistServiceimpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;

	public void addplaylist(Playlist playlist) {
		playlistRepository.save(playlist);
		
	}

	public List<Playlist> fetchAllPlaylists() {
		List<Playlist> playlist=playlistRepository.findAll();
		return playlist;
	}
	

}
