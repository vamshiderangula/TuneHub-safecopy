package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.serviceimpl.PlaylistServiceimpl;
import com.kodnest.tunehub.serviceimpl.SongServiceimpl;

@Controller
public class PlaylistController {
	@Autowired
	SongServiceimpl songServiceimpl;
	@Autowired
	PlaylistServiceimpl playlistServiceimpl;

	@GetMapping("/createplaylists")
	public String createplaylists(Model model) {
		List<Song> songList=songServiceimpl.fetchAllSongs();
		model.addAttribute("song", songList);
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String  addplaylist(@ModelAttribute Playlist playlist) {
		playlistServiceimpl.addplaylist(playlist);
		List<Song> songlist =playlist.getSongs();
		for(Song s:songlist) {
			s.getPlaylists().add(playlist);	
			songServiceimpl.updateSong(s);
		}


		return "admin";

	}
	@GetMapping("/viewplaylists")
	public String  viewplaylists(Model model) {
		List<Playlist> playlist=playlistServiceimpl.fetchAllPlaylists();
		model.addAttribute("playlists", playlist);
		return "viewplaylist";

	}

}
