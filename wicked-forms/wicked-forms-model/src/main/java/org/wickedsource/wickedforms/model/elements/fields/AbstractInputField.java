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
package org.wickedsource.wickedforms.model.elements.fields;

import org.wickedsource.wickedforms.model.actions.FormAction;
import org.wickedsource.wickedforms.model.binding.Binding;
import org.wickedsource.wickedforms.model.elements.AbstractBoundField;
import org.wickedsource.wickedforms.model.validation.FieldValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all input fields that can be part of a dynamic form. All input
 * fields can display a value to a user as well as take a value as input from a
 * user.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of the user input
 */
public abstract class AbstractInputField<T> extends
		AbstractBoundField<T> {

	private String label;

	private String hint;

	private boolean required = false;

	private boolean enabled = true;

	private String requiredMessage;

	private final List<FieldValidator<T>> validators = new ArrayList<FieldValidator<T>>();

	private final List<FormAction<T>> actions = new ArrayList<FormAction<T>>();

	private T userInput;

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            the label of the input field. This label should be displayed
	 *            next to the input field itself, so that it is clear what input
	 *            the user is expected to give.
	 */
	public AbstractInputField(final String label) {
		this.label = label;
	}

	/**
	 * Constructor with initial value.
	 * 
	 * @param label
	 *            the label of the input field. This label should be displayed next
	 *            to the input field itself, so that it is clear what input the
	 *            user is expected to give.
	 * @param value
	 *            the initial value of the input field.
	 */
	public AbstractInputField(final String label, final T value) {
		super(value);
		this.label = label;
	}

	/**
	 * Constructor with binding.
	 * 
	 * @param label
	 *            the label of the input field. This label should be displayed
	 *            next to the input field itself, so that it is clear what input
	 *            the user is expected to give.
	 * @param binding
	 *            a binding defining a link between this input field and an
	 *            arbitrary object.
	 */
	public AbstractInputField(final String label, final Binding<T> binding) {
		super(binding);
		this.label = label;
	}

	public AbstractInputField() {

	}

	public AbstractInputField<T> setLabel(final String label) {
		this.label = label;
		return this;
	}

	public String getLabel() {
		return this.label;
	}

	/**
	 * Adds a validator to this input field. The validators are executed when
	 * the user submits the form.
	 * 
	 * @param validator
	 *            the validator to add.
	 * @return this object for chaining
	 */
	public AbstractInputField<T> add(final FieldValidator<T> validator) {
		this.getValidators().add(validator);
		return this;
	}

	public AbstractInputField<T> add(final FormAction<T> action) {
		this.getActions().add(action);
		return this;
	}

	/**
	 * Sets an optional hint for the input field. This hint may for example be
	 * displayed as a info to the user next to the input field or as a
	 * mouse-over popup.
	 * 
	 * @param hint
	 *            the hint of the input field.
	 * @return this object for chaining
	 */
	public AbstractInputField<T> setHint(final String hint) {
		this.hint = hint;
		return this;
	}

	public String getHint() {
		return this.hint;
	}

	/**
	 * Defines if this input field is mandatory and thus must be filled by the
	 * user.
	 * 
	 * @param required
	 *            true, if the field should be mandatory and the form cannot be
	 *            submitted without filling this input field.
	 * @return this object for chaining
	 */
	public AbstractInputField<T> setRequired(final boolean required) {
		this.required = required;
		return this;
	}

	public boolean isRequired() {
		return this.required;
	}

	/**
	 * Sets the message that is displayed to the user if he did not fill this
	 * input field although it was defined as required.
	 * 
	 * @param requiredMessage
	 *            the message to display when not filling this required input
	 *            field.
	 * @return this object for chaining
	 */
	public AbstractInputField<T> setRequiredMessage(final String requiredMessage) {
		this.requiredMessage = requiredMessage;
		return this;
	}

	public String getRequiredMessage() {
		return this.requiredMessage;
	}

	public List<FieldValidator<T>> getValidators() {
		return this.validators;
	}

	/**
	 * Stores the user's input. This field is intended to be used by Wicked
	 * Forms interpreters to store the user's input BEFORE validation has
	 * occured. Validators may use this field to validate user input before the
	 * value is passed into the binding.
	 * <p/>
	 * This method should NOT be called by users of Wicked Forms but only by
	 * Wicked Forms interpreters.
	 * 
	 * @param userInput
	 *            the user's input into this field.
	 */
	public void setUserInput(final T userInput) {
		this.userInput = userInput;
	}

	/**
	 * Returns the user's input. This field is intended to be used by Wicked
	 * Forms interpreters to store the user's input BEFORE validation has
	 * occured. Validators may use this field to validate user input before the
	 * value is passed into the binding.
	 * <p/>
	 * This method should be called instead of getValue() by Validators to
	 * validate the user's input. The getValue() method may not contain the
	 * correct value in the validation phase.
	 * 
	 * @return the user's input into this field.
	 */
	public T getUserInput() {
		return this.userInput;
	}

	/**
	 * Enables or disables an input field. Disabled input fields cannot be
	 * filled out by the user.
	 * 
	 * @param enabled
	 *            true to enable, false to disable.
	 * @return this object for chaining
	 */
	public AbstractInputField<T> setEnabled(final boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public List<FormAction<T>> getActions() {
		return this.actions;
	}

	/**
	 * Returns the class of object this input fields takes as input.
	 * <p/>
	 * Must be overridden by sub types in order for actions to properly update
	 * the user input.
	 * 
	 * @return class of the user input into this input field.
	 */
	public Class<?> getModelClass() {
		return Object.class;
	}

}
