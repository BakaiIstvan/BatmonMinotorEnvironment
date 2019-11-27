import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Specification{
	private String id = "spec1";
	private ArrayList<Automaton> automatas;
	
	public Specification(){
		automatas = new ArrayList<Automaton>();
		String str;
		State actualState;
		State acceptState;
		State finalState;
		State newState;
		State acceptState_new;
		Automaton a = new Automaton("Junction");
		Automaton b;
		ArrayList<Automaton> altauto;
		ArrayList<Automaton> parauto;
		Automaton loopauto;
		Automaton expression;
		int counter = 0;
		
		
		b = new Automaton("auto3");
		actualState = new State("q" + counter, StateType.ACCEPT);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		
		b.addTransition(new Transition("!(" + "match(" + "Junction" + ", " + "Redlight" + "))", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("match(" + "Junction" + ", " + "Redlight" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
		a.collapse(b);
		b = new Automaton("auto7");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
											
		b.addTransition(new Transition("1", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("controller" + "." + "turnYellow()" + "." + "lamp" , actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
		a.collapse(b);
		
		str = "" 
		+ "!(" + "controller" + "." + "turnOff()" + "." + "lamp)" + " & "
								;
		str= str.substring(0, str.length() - 3);
		b = new Automaton("auto7");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
												
		b.addTransition(new Transition(str, actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("lamp" + "." + "updateStatus()" + "." + "controller", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
		a.collapse(b);
		
		b = new Automaton("auto12");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("changeTo(" + "Junction" + "." + "Car" + "." + "speed, 20.0" + ")", actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
		a.collapse(b);																																				
		
		
		b = new Automaton("match1");
		actualState = new State("q" + counter, StateType.NORMAL);
		counter++;
		b.addState(actualState);
		b.setInitial(actualState);
		
		b.addTransition(new Transition("1", actualState, actualState));
		newState = new State("q" + counter, StateType.FINAL);
		counter++;
		b.addTransition(new Transition("changeTo(" + "Junction" + "." + "Distance" + "." + "meter, 6" + ")" , actualState, newState));
		b.addState(newState);
		b.setFinale(newState);
		a.collapse(b);																																	
		a.rename();
		automatas.add(a);
	}
	
	public void listAutomatas(){
		for(Automaton a : this.automatas){
			for(State s : a.getStates()){
				s.writeState();	
			}
			
			for(Transition t : a.getTransitions()){
				t.writeTransition();
			}
		}
	}
	
	public ArrayList<Automaton> par(ArrayList<Automaton> automatas) {
	        ArrayList<ArrayList<Automaton>> automataList = new ArrayList<>();
	        permute(automataList, new ArrayList<>(), automatas);
	        return listConverter((automataList));
	}

    private void permute(ArrayList<ArrayList<Automaton>> list, ArrayList<Automaton> resultList, ArrayList<Automaton> automatas) {
        if (resultList.size() == automatas.size()) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < automatas.size(); i++) {
                if (resultList.contains((automatas.get(i)))) {
                    continue;
                }

                resultList.add(automatas.get(i));
                permute(list, resultList, automatas);
                resultList.remove(resultList.size() - 1);
            }
        }
    }

    private ArrayList<Automaton> listConverter(ArrayList<ArrayList<Automaton>> list) {
        ArrayList<Automaton> result = new ArrayList<>();
        for (ArrayList<Automaton> alist : list) {
            Automaton newauto = new Automaton("listConverter");
            for (Automaton auto : alist) {
                newauto.collapse(copyAutomaton(auto));
            }
            result.add(newauto);
        }
        return result;
    }
    
    public ArrayList<Automaton> loopSetup(Automaton loopauto, int min, int max) {
	            ArrayList<Automaton> result = new ArrayList<>();
	    
	            for (int i = min; i <= max; i++) {
	                Automaton newauto = new Automaton("loopauto");
	                for (int j = 0; j < i; j++) {
	                    newauto.collapse(copyAutomaton(loopauto));
	                }
	                result.add(newauto);
	            }
	            return result;
    }
    
    public Automaton copyAutomaton(Automaton referenceAuto) {
            Automaton result = new Automaton("copy automaton");
            int count = 0;
            State previousSender = new State();
            State referencePreviousSender = new State();
    
            for (Transition t : referenceAuto.getTransitions()) {
                State sender = new State();
                State receiver = new State();
                Transition transition = new Transition();
                Automaton temp = new Automaton("temp");
    
                transition.setId(t.getId());
    
                if (t.getSender() == referencePreviousSender) {
                    receiver.setId("c" + count);
                    count++;
                    receiver.setType(t.getReceiver().getType());
    
                    transition.setSender(previousSender);
                    transition.setReceiver(receiver);
                    temp.addState(previousSender);
                    temp.addState(receiver);
                    temp.setInitial(previousSender);
                    temp.setFinale(receiver);
                } else {
                    if (t.getSender() == t.getReceiver()) {
                        sender.setId("c" + count);
                        count++;
                        sender.setType(t.getSender().getType());
    
                        transition.setSender(sender);
                        transition.setReceiver(sender);
    
                        temp.addState(sender);
                        temp.setInitial(sender);
                        temp.setFinale(sender);
                    } else {
                        sender.setId("c" + count);
                        count++;
                        sender.setType(t.getSender().getType());
    
                        receiver.setId("c" + count);
                        count++;
                        receiver.setType(t.getReceiver().getType());
    
                        transition.setSender(sender);
                        transition.setReceiver(receiver);
    
                        temp.addState(sender);
                        temp.addState(receiver);
                        temp.setInitial(sender);
                        temp.setFinale(receiver);
                    }
                    previousSender = sender;
                    referencePreviousSender = t.getSender();
                }
    
                temp.addTransition(transition);
                result.collapse(temp);
            }
    
            return result;
        }
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		Specification specification = new Specification();
		specification.listAutomatas();
		boolean acceptState = false;
		
		PrintWriter writer = new PrintWriter("spec1" + ".txt", "UTF-8");
		for(Automaton a : specification.automatas){
			writer.println("never{ /*" + a.getId()+ "Monitor" + "*/");
			for(State s : a.getStates()){
				if(s == a.getInitial()){
					writer.println("T0_init:");
					writer.println(" do");
					for(Transition t : a.findSender(s)){
						if(t.getReceiver() == a.getInitial()){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_init");
						}else if(t.getReceiver().getType().equals(StateType.NORMAL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT_ALL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto accept_all" );
						}else if(t.getReceiver().getType().equals(StateType.FINAL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto accept_" + t.getReceiver().getId());
						}
					}
					writer.println(" od;");
				}else if(s.getType().equals(StateType.NORMAL)){
					writer.println("T0_" + s.getId() + ":");
					writer.println(" do");
					for(Transition t : a.findSender(s)){
						if(t.getReceiver() == a.getInitial()){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_init");
						}else if(t.getReceiver().getType().equals(StateType.NORMAL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT_ALL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto accept_all" );
						}else if(t.getReceiver().getType().equals(StateType.FINAL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto accept_" + t.getReceiver().getId());
						}
					}
					writer.println(" od;");
				}else if(s.getType().equals(StateType.ACCEPT_ALL) && !acceptState){
					writer.println("accept_all:");
					writer.println("skip");
					acceptState = true;
				}else if(s.getType().equals(StateType.FINAL)){
					writer.println("T0_" + s.getId() + ":");
					writer.println(" do");
					for(Transition t : a.findSender(s)){
						if(t.getReceiver() == a.getInitial()){
							writer.println(" :: (" + t.getId() + ")" + "->" + " goto T0_init");
						}else if(t.getReceiver().getType().equals(StateType.NORMAL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT_ALL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto accept_all" );
						}else if(t.getReceiver().getType().equals(StateType.FINAL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto accept_" + t.getReceiver().getId());
						}
					}
					writer.println(" od;");
				}else if(s.getType().equals(StateType.ACCEPT)){
					writer.println("accept_" + s.getId() + ":");
					writer.println(" do");
					for(Transition t : a.findSender(s)){
						if(t.getReceiver() == a.getInitial()){
							writer.println(" :: (" + t.getId() + ")" + "->" + " goto T0_init");
						}else if(t.getReceiver().getType().equals(StateType.NORMAL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT_ALL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto accept_all" );
						}else if(t.getReceiver().getType().equals(StateType.FINAL)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto T0_" + t.getReceiver().getId());
						}else if(t.getReceiver().getType().equals(StateType.ACCEPT)){
							writer.println(" :: (" + t.getId() + ") " + "->" + " goto accept_" + t.getReceiver().getId());
						}
					}
					writer.println(" od;");
				}
				
			}
			writer.println("}");
		}
		writer.close();
	}
}
