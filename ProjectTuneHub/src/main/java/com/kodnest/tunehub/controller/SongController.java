package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.serviceimpl.SongServiceimpl;
@Controller
public class SongController {
	@Autowired
	SongServiceimpl songServiceimpl;
	
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song) {

			boolean status=songServiceimpl.songExists(song.getName());
			if(status==false) {
				songServiceimpl.addSong(song);
				System.out.println("added succedsfully");
			}
			else {
				System.out.println("song already exist");
			}
			
			
			return "admin";
	}
	@GetMapping("/viewsong")
	public String viewsong(Model model) {
		List<Song> songList=songServiceimpl.fetchAllSongs();
		model.addAttribute("song", songList);
		return "displaysongs";
	}
	@GetMapping("/playsongs")
	public String playsongs(Model model) {
		boolean premium=false;
		if(premium) {
			List<Song> songList=songServiceimpl.fetchAllSongs();
			model.addAttribute("song", songList);
			return "song";
		}
		else {
			return "subscriptionform";
		}
	}

	
}
