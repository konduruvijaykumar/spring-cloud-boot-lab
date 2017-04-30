/**
 * 
 */
package org.pjay.model;

/**
 * @author vijayk
 *
 */
public class Word {

	private String word;
	private Role role;

	public Word() {
	}

	public Word(String word) {
		this.word = word;
	}
	
	public Word(String word, Role role) {
		this.word = word;
		this.role = role;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	// Enum class
	public static enum Role{
		subject, verb, article, adjective, noun;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (role != other.role)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", role=" + role + "]";
	}

}
