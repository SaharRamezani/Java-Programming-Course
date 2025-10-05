public class MageScroll extends GuardianScroll  {
    public MageScroll(String successorKnowledge) {
        super(successorKnowledge);
    }

    public MageScroll() {
        super();
    }
    
    public void addAlliancePact(String pact){
        alliancePacts.add(pact);
    }
}
