package hello;

public class Artist {

	private String form;
	
	public Artist(String form) {
		super();
		this.form = form;
	}

	public boolean isForm(String form) {
		if (this.form.equals(form)) {
			return true;
		}
		return false;
	}

}
