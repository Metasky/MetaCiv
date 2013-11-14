package civilisation.individu.plan.action;

import java.util.ArrayList;

import civilisation.individu.Humain;
import civilisation.inventaire.Objet;

public class A_ChangeAttribute extends Action{

	String attributeName;
	Integer variation;

	@Override
	public Action effectuer(Humain h) {
		h.getAttr().put(attributeName, h.getAttr().get(attributeName) + variation );
		return nextAction;
	}

	@Override
	public void parametrerOption(OptionsActions option){
		super.parametrerOption(option);
		
		for (int i = 0 ; i < option.getParametres().size(); i++) {
			System.out.println(option.getParametres().get(i).toString());
		}
		
		if (option.getParametres().get(0).getClass() == String.class) {
			attributeName = (String) option.getParametres().get(0);
		} else if (option.getParametres().get(0).getClass() == Integer.class) {
			variation = (Integer) option.getParametres().get(0);
		}

	}
	
	@Override
	public ArrayList<String[]> getSchemaParametres(){
		
		if (schemaParametres == null){
			schemaParametres = new ArrayList<String[]>();
			String[] attrName = {"**Attribute**" , "Changed attribute"};
			String[] n = {"**Integer**" , "n", "-20" , "20" , "0"};

			schemaParametres.add(attrName);
			schemaParametres.add(n);

		}
		return schemaParametres;	
	}

	
}