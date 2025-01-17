public class Survey {
    private int id;
    private String question;
    
	public Survey(int id, String question) {
		super();
		this.id = id;
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

    
}