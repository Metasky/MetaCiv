package civilisation.individu.plan.action;

import javax.swing.ImageIcon;

import civilisation.individu.Humain;

public class L_Instant extends Action{
	
	@Override
	public Action effectuer(Humain h) {	
		
		Action next = listeActions.get(0);
		while ((next = next.effectuer(h)) != null);

		return nextAction;
	}

	@Override
	public ImageIcon getIcon(){
		return new ImageIcon(this.getClass().getResource("../../../inspecteur/icones/processor.png"));
	}
	
	@Override
	public int getNumberActionSlot(){
		return -1;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + " All actions includes in this logical controller will be played in one tick.<html>";
	}
	
}
