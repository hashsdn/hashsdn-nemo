/*
 * generated by Xtext
 */
package org.opendaylight.nemo.tool.eclipse.plugin.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class EditorAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/opendaylight/nemo/tool/eclipse/plugin/parser/antlr/internal/InternalEditor.tokens");
	}
}
