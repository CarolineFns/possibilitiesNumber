package com.b2w.task;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CandidateNumbersTest {

	@Test
	public void validationWithInput432() {
		// given
		Task task = new Task();

		// when
		int result = task.rearrange(432);

		// then
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void validationWithInput120() {
		// given
		Task task = new Task();

		// when
		int result = task.rearrange(120);

		// then
		assertThat(result).isEqualTo(4);
	}
}
