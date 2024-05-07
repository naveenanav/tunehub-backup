package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.repository.PlaylistRepository;
import com.kodnest.tunehub.service.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addPlaylist(Playlist playlist) 
	{
		Playlist existingplaylist=playlistRepository.findByName(playlist.getName());
		if(existingplaylist==null)
		{
			playlistRepository.save(playlist);
		}
		else
		{
			System.out.println("Playlist already exists!");
		}
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		List<Playlist> playlists=playlistRepository.findAll();
		return playlists;
	}
}
