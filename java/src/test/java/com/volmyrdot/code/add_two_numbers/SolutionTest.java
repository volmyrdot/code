package com.volmyrdot.code.add_two_numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Solution}.
 */
class SolutionTest {

    @Test
    void shouldAddTwoNumbers() {
        Solution.ListNode listNode11 = new Solution.ListNode(3);
        Solution.ListNode listNode12 = new Solution.ListNode(4, listNode11);
        Solution.ListNode listNode13 = new Solution.ListNode(2, listNode12);

        Solution.ListNode listNode21 = new Solution.ListNode(4);
        Solution.ListNode listNode22 = new Solution.ListNode(6, listNode21);
        Solution.ListNode listNode23 = new Solution.ListNode(5, listNode22);

        Solution.ListNode expect1 = new Solution.ListNode(8);
        Solution.ListNode expect2 = new Solution.ListNode(0, expect1);
        Solution.ListNode expect3 = new Solution.ListNode(7, expect2);

        assertThat(new Solution().addTwoNumbers(listNode13, listNode23)).isEqualTo(expect3);
    }

    @Test
    void shouldAddTwoNumbers1() {
        Solution.ListNode listNode11 = new Solution.ListNode(0);
        Solution.ListNode listNode21 = new Solution.ListNode(0);
        Solution.ListNode expect1 = new Solution.ListNode(0);

        assertThat(new Solution().addTwoNumbers(listNode11, listNode21)).isEqualTo(expect1);
    }

    @Test
    void shouldAddTwoNumbers2() {
        Solution.ListNode listNode11 = new Solution.ListNode(9);
        Solution.ListNode listNode12 = new Solution.ListNode(9, listNode11);
        Solution.ListNode listNode13 = new Solution.ListNode(9, listNode12);
        Solution.ListNode listNode14 = new Solution.ListNode(9, listNode13);
        Solution.ListNode listNode15 = new Solution.ListNode(9, listNode14);
        Solution.ListNode listNode16 = new Solution.ListNode(9, listNode15);
        Solution.ListNode listNode17 = new Solution.ListNode(9, listNode16);

        Solution.ListNode listNode21 = new Solution.ListNode(9);
        Solution.ListNode listNode22 = new Solution.ListNode(9, listNode21);
        Solution.ListNode listNode23 = new Solution.ListNode(9, listNode22);
        Solution.ListNode listNode24 = new Solution.ListNode(9, listNode23);

        Solution.ListNode expect1 = new Solution.ListNode(1);
        Solution.ListNode expect2 = new Solution.ListNode(0, expect1);
        Solution.ListNode expect3 = new Solution.ListNode(0, expect2);
        Solution.ListNode expect4 = new Solution.ListNode(0, expect3);
        Solution.ListNode expect5 = new Solution.ListNode(9, expect4);
        Solution.ListNode expect6 = new Solution.ListNode(9, expect5);
        Solution.ListNode expect7 = new Solution.ListNode(9, expect6);
        Solution.ListNode expect8 = new Solution.ListNode(8, expect7);

        assertThat(new Solution().addTwoNumbers(listNode17, listNode24)).isEqualTo(expect8);
    }
}
