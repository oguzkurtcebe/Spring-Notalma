package com.oguzkurtcebe.service;

import java.util.ArrayList;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguzkurtcebe.dao.NoteDAO;
import com.oguzkurtcebe.entity.Note;
import com.oguzkurtcebe.entity.User;
import com.oguzkurtcebe.security.LoginFilter;
import com.oguzkurtcee.dto.UserLoginDto;

@Service
@Transactional
public class NoteService {
	@Autowired
	private NoteDAO noteDAO;
	 
	@Autowired
	private UserService userService;

	public long createNote(Note note, HttpServletRequest request) {
		// TODO User id deðiþecek
		note.setUser_id(LoginFilter.user.getId());
		return noteDAO.insert(note);

	}

	public long updateNote(Note note, HttpServletRequest request) {

		noteDAO.update(note);
		return 1l;
	}

	public long deleteNote(Note note, HttpServletRequest request) {

		noteDAO.delete(note);
		return 1l;
	}
	public Note getNoteFindById(Long id) {
		return noteDAO.getFindById(id);
	}

	public ArrayList<Note> getAll() {

		return noteDAO.getAll();
	}

	public ArrayList<Note> getAll(Long userId) {

		return noteDAO.getAll(userId);
	}
	public ArrayList<Note> getAll(UserLoginDto login) {
        User userm=new User();
        userm.setUsername(login.getUsername());
        userm.setPass(login.getPass());
        User user=userService.getFindByUsernameAndPass(userm);
		return noteDAO.getAll(user.getId());
	}
}
