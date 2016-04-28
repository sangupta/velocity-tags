package com.sangupta.velocity.directives;

import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.ReadableUtils;

public class ReadableTimeDirective extends Directive {

	@Override
	public String getName() {
		return "readableTime";
	}
	
	@Override
	public int getType() {
		return LINE;
	}
	
	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		String millis = null;
		
		if(node.jjtGetChild(0) != null) {
			millis = String.valueOf(node.jjtGetChild(0).value(context));
		}
		
		if(AssertUtils.isEmpty(millis)) {
			return true;
		}

		try {
			long millisLong = Long.parseLong(millis);
			String str = ReadableUtils.getReadableTimeDuration(millisLong);
			writer.write(str);
		} catch(NumberFormatException e) {
			// eat up
		}
		
		return true;
	}

}
