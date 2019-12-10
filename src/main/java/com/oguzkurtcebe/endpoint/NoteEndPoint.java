package com.oguzkurtcebe.endpoint;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oguzkurtcebe.entity.Note;
import com.oguzkurtcebe.service.NoteService;
import com.oguzkurtcee.dto.UserLoginDto;

@RestController
@RequestMapping("/rest")
public class NoteEndPoint {

	@Autowired
	private NoteService noteservice;
	
	@RequestMapping(value="/getAll", method=RequestMethod.POST)
	public ResponseEntity<ArrayList<Note>>getNotes(@RequestBody UserLoginDto login){
	
		return new ResponseEntity<>(noteservice.getAll(login),HttpStatus.OK);
	}
}
