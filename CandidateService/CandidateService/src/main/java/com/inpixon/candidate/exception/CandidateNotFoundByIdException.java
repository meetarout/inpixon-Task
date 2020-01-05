package com.inpixon.candidate.exception;

public class CandidateNotFoundByIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2240274415156012983L;
	
	public String msg="No Candidate Found For This Id";
	
	
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CandidateNotFoundByIdException(String message) {
		super(message);
	}
	
	public CandidateNotFoundByIdException() {
		super();
	}

	
	
}
