package com.oguzkurtcebe.service;

import java.util.ArrayList;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguzkurtcebe.dao.NoteDAO;
import com.oguzkurtcebe.entity.Note;

@Service
@Transactional
public class NoteService {
	@Autowired
private NoteDAO noteDAO;
	public long createNote(Note note,HttpServletRequest request) {
		//TODO User id de�i�ecek
		note.setUser_id(1l);
		return noteDAO.insert(note);
		
	}

	public Note getFindNoteById(Long userId) {
		return noteDAO.getFindById(userId);
	}
	public ArrayList<Note> getAll() {
		
		return noteDAO.getAll();
	}

public ArrayList<Note> getAll(Long userId) {
		
		return noteDAO.getAll(userId);
	}
}
