package vehiclerentalservice;

public class Staff {

    private String staffId;
    private String name;
    private String ic;
    private String phoneNo;
    private String email;
    private String question;
    private String answer;
    private String password;

    public Staff(String staffId, String name, String ic, String phoneNo, String email, String question, String answer, String password) {
        this.staffId = staffId;
        this.name = name;
        this.ic = ic;
        this.phoneNo = phoneNo;
        this.email = email;
        this.question = question;
        this.answer = answer;
        this.password = password;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Staff ID = " + staffId
                + "\nName = " + name
                + "\nIC = " + ic
                + "\nPhone Number = " + phoneNo
                + "\nEmail = " + email
                + "\nQuestion = " + question
                + "\nAnswer = " + answer
                + "\nPassword = " + password;
    }

}
