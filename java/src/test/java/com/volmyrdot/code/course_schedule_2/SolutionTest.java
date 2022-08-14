package com.volmyrdot.code.course_schedule_2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Solution}.
 */
class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void shouldFindOrder(int numCourses, int[][] prerequisites, int[] expected) {
        assertThat(new Solution().findOrder(numCourses, prerequisites)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1, 0}}, new int[]{0, 1}),
                Arguments.of(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}, new int[]{0, 2, 1, 3}),
                Arguments.of(2, new int[][]{{1, 0}, {0, 1}}, new int[0]),
                Arguments.of(1, new int[][]{}, new int[]{0})
        );
    }
}
