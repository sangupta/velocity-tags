package com.sangupta.velocity.directives;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

public class MapGetDirective extends Directive {

	@Override
	public String getName() {
		return "mapGet";
	}
	
	@Override
	public int getType() {
		return LINE;
	}
	
	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		Object map = node.jjtGetChild(0).value(context);
		Object key = node.jjtGetChild(1).value(context);

		if(map == null) {
			return true;
		}
		
		if(key == null) {
			return true;
		}
		
		if(!(map instanceof Map<?, ?>)) {
			return true;
		}
		
		Map<?, ?> instance = (Map<?, ?>) map;
		Object value = instance.get(key);
		if(value == null) {
			return true;
		}
		
		writer.write(value.toString());
		return true;
	}

}
