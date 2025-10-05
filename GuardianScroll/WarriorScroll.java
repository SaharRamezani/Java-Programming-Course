public class WarriorScroll extends GuardianScroll {  
    public WarriorScroll(String successorKnowledge) {
        super(successorKnowledge);
    }

    public WarriorScroll() {
        super();
    }
    
    public void addAlliancePact(String pact){
        alliancePacts.add(pact);
    }
}
