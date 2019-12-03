package com.oguzkurtcebe.service;

import java.util.ArrayList;

import javax.persistence.Query;

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
	public long createNote(Note note) {
		return noteDAO.insert(note);
	}

	public ArrayList<Note> getAll() {
		
		return noteDAO.getAll();
	}

}
