/*
 * Copyright 2023-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ai.vertexai.palm2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.ai.chat.prompt.ChatOptions;

/**
 * @author Christian Tzolov
 * @author Thomas Vitale
 */
@JsonInclude(Include.NON_NULL)
public class VertexAiPaLm2ChatOptions implements ChatOptions {

	// @formatter:off
	/**
	 * Controls the randomness of the output. Values can range over [0.0,1.0], inclusive.
	 * A value closer to 1.0 will produce responses that are more varied, while a value
	 * closer to 0.0 will typically result in less surprising responses from the
	 * generative. This value specifies default to be used by the backend while making the
	 * call to the generative.
	 */
	private @JsonProperty("temperature") Double temperature;

	/**
	 * The number of generated response messages to return. This value must be between [1,
	 * 8], inclusive. Defaults to 1.
	 */
	private @JsonProperty("candidateCount") Integer candidateCount;

	/**
	 * The maximum cumulative probability of tokens to consider when sampling. The
	 * generative uses combined Top-k and nucleus sampling. Nucleus sampling considers the
	 * smallest set of tokens whose probability sum is at least topP.
	 */
	private @JsonProperty("topP") Double topP;

	/**
	 * The maximum number of tokens to consider when sampling. The generative uses
	 * combined Top-k and nucleus sampling. Top-k sampling considers the set of topK most
	 * probable tokens.
	 */
	private @JsonProperty("topK") Integer topK;
	// @formatter:on

	public static Builder builder() {
		return new Builder();
	}

	public static VertexAiPaLm2ChatOptions fromOptions(VertexAiPaLm2ChatOptions fromOptions) {
		return VertexAiPaLm2ChatOptions.builder()
			.withTemperature(fromOptions.getTemperature())
			.withCandidateCount(fromOptions.getCandidateCount())
			.withTopP(fromOptions.getTopP())
			.withTopK(fromOptions.getTopK())
			.build();
	}

	@Override
	public Double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Integer getCandidateCount() {
		return this.candidateCount;
	}

	public void setCandidateCount(Integer candidateCount) {
		this.candidateCount = candidateCount;
	}

	@Override
	public Double getTopP() {
		return this.topP;
	}

	public void setTopP(Double topP) {
		this.topP = topP;
	}

	@Override
	public Integer getTopK() {
		return this.topK;
	}

	public void setTopK(Integer topK) {
		this.topK = topK;
	}

	@Override
	@JsonIgnore
	public String getModel() {
		return null;
	}

	@Override
	@JsonIgnore
	public Integer getMaxTokens() {
		return null;
	}

	@Override
	@JsonIgnore
	public List<String> getStopSequences() {
		return null;
	}

	@Override
	@JsonIgnore
	public Double getFrequencyPenalty() {
		return null;
	}

	@Override
	@JsonIgnore
	public Double getPresencePenalty() {
		return null;
	}

	@Override
	public VertexAiPaLm2ChatOptions copy() {
		return fromOptions(this);
	}

	public static class Builder {

		private VertexAiPaLm2ChatOptions options = new VertexAiPaLm2ChatOptions();

		public Builder withTemperature(Double temperature) {
			this.options.temperature = temperature;
			return this;
		}

		public Builder withCandidateCount(Integer candidateCount) {
			this.options.candidateCount = candidateCount;
			return this;
		}

		public Builder withTopP(Double topP) {
			this.options.topP = topP;
			return this;
		}

		public Builder withTopK(Integer topK) {
			this.options.topK = topK;
			return this;
		}

		public VertexAiPaLm2ChatOptions build() {
			return this.options;
		}

	}

}
