/**
 *
 * velocity-tags - Collection of useful Apache Velocity directives
 * Copyright (c) 2010-2016, Sandeep Gupta
 * 
 * http://sangupta.com/projects/velocity-tags
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.velocity.directives;

import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

public class AtomicNumDirective extends Directive {

	@Override
	public String getName() {
		return "atomicNum";
	}
	
	@Override
	public int getType() {
		return LINE;
	}
	
	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		if(node.jjtGetChild(0) == null) {
			return true;
		}
		
		Object obj = node.jjtGetChild(0).value(context);
		if(obj == null) {
			return true;
		}

		String value = null;
		
		if(obj instanceof AtomicInteger) {
			value = String.valueOf(((AtomicInteger) obj).get());
		} else if(obj instanceof AtomicLong) {
			value = String.valueOf(((AtomicLong) obj).get());
		}
		
		if(value != null) {
			writer.write(value);
		}
		
		return true;
	}
	
}