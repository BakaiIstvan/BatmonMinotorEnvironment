public class Transition {
    private String id;
    private State sender;
    private State receiver;
    
    public Transition() {
            this.id = "t0";
            this.sender = new State();
            this.receiver = new State();
    }

    public Transition(String id, State sender, State receiver) {
    	if(id.equals("1")){
    		this.id = "true";
    	}else{
        	this.id = id;
        }
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getId() {
        return id;
    }

    public State getSender() {
        return sender;
    }

    public State getReceiver() {
        return receiver;
    }

    public void setReceiver(State receiver) {
        this.receiver = receiver;
    }

    public void setSender(State sender) {
        this.sender = sender;
    }

    public void setId(String id) {
        if(id.equals("1")){
        	this.id = "true";
        }else{
        	this.id = id;
        }
    }
    
    public void writeTransition(){
    	System.out.println(this.id + " " + this.sender.getId() + "->" + this.receiver.getId());
    }
}
