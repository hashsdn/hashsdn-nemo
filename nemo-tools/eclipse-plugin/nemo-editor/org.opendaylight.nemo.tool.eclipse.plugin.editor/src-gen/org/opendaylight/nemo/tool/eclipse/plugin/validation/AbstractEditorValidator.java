/*
 * generated by Xtext
 */
package org.opendaylight.nemo.tool.eclipse.plugin.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractEditorValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.opendaylight.nemo.tool.eclipse.plugin.editor.EditorPackage.eINSTANCE);
		return result;
	}
}
