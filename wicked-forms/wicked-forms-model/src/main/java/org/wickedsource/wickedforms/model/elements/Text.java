/**
 *   Copyright 2013 Wicked Forms (https://github.com/thombergs/wicked-forms)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.wickedsource.wickedforms.model.elements;

import org.wickedsource.wickedforms.model.binding.Binding;

/**
 * A form element that simply displays a text. It should be treated as read only
 * by an interpreter.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class Text extends AbstractBoundField<String> {

	/**
	 * Constructor.
	 * 
	 * @param text
	 *            the text that should be displayed by this form element.
	 */
	public Text(String text) {
		super(text);
	}

	/**
	 * Constructor with binding.
	 * 
	 * @param binding
	 *            the binding to back this form element.
	 * @see AbstractFormElement#FormElement(Binding)
	 */
	public Text(Binding<String> binding) {
		super(binding);
	}

}
