/*
 * $Header: /cvshome/build/org.osgi.service.deploymentadmin/src/org/osgi/service/deploymentadmin/spi/ResourceProcessorException.java,v 1.7 2006/07/12 21:22:10 hargrave Exp $
 * 
 * Copyright (c) OSGi Alliance (2005, 2006). All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.osgi.service.deploymentadmin.spi;

import java.io.InputStream;

/**
 * Checked exception received when something fails during a call to a Resource 
 * Processor. A <code>ResourceProcessorException</code> always contains an error 
 * code (one of the constants specified in this class), and may optionally contain 
 * the textual description of the error condition and a nested cause exception.
 */
public class ResourceProcessorException extends Exception {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 9135007015668223386L;

	/**
	 * Resource Processors are allowed to raise an exception with this error code 
	 * to indicate that the processor is not able to commit the operations it made 
	 * since the last call of {@link ResourceProcessor#begin(DeploymentSession)} method.<p>
	 * 
	 * Only the {@link ResourceProcessor#prepare()} method is allowed to throw exception 
	 * with this error code.  
	 */
	public static final int	CODE_PREPARE					= 1;

	/**
	 * An artifact of any resource already exists.<p>
	 * 
	 * Only the {@link ResourceProcessor#process(String, InputStream)} method 
	 * is allowed to throw exception with this error code.  
	 */
	public static final int	CODE_RESOURCE_SHARING_VIOLATION	= 461;

	/**
	 * Other error condition.<p>
	 * 
	 * All Resource Processor methods which throw <code>ResourceProcessorException</code> 
	 * is allowed throw an exception with this erro code if the error condition cannot be 
	 * categorized. 
	 */
	public static final int	CODE_OTHER_ERROR				= 463;

	private final int				code;
	private final String			message;
	private final Throwable		cause;

	/**
	 * Create an instance of the exception.
	 * 
	 * @param code The error code of the failure. Code should be one of the
	 *        predefined integer values (<code>CODE_X</code>).
	 * @param message Message associated with the exception
	 * @param cause the originating exception
	 */
	public ResourceProcessorException(int code, String message, Throwable cause) {
		this.code = code;
		this.message = message;
		this.cause = cause;
	}

	/**
	 * Create an instance of the exception. Cause exception is implicitly set to
	 * null.
	 * 
	 * @param code The error code of the failure. Code should be one of the
	 *        predefined integer values (<code>CODE_X</code>).
	 * @param message Message associated with the exception
	 */
	public ResourceProcessorException(int code, String message) {
		this(code, message, null);
	}

	/**
	 * Create an instance of the exception. Cause exception and message are
	 * implicitly set to null.
	 * 
	 * @param code The error code of the failure. Code should be one of the
	 *        predefined integer values (<code>CODE_X</code>).
	 */
	public ResourceProcessorException(int code) {
		this(code, null, null);
	}

	/**
	 * @return Returns the cause.
	 */
	public Throwable getCause() {
		return cause;
	}

	/**
	 * @return Returns the code.
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
	    return message;
	}
}
