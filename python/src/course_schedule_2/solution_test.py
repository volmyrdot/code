from parameterized import parameterized
import unittest

from python.src.course_schedule_2.solution import Solution


class SolutionTests(unittest.TestCase):
    @parameterized.expand([
        [2, [[1, 0]], [0, 1]],
        [4, [[1, 0], [2, 0], [3, 1], [3, 2]], [0, 2, 1, 3]],
        [2, [[1, 0], [0, 1]], []],
        [1, [], [0]]
    ])
    def test_sequence(self, num_courses, prerequisites, expected):
        self.assertEqual(Solution().find_order(num_courses, prerequisites), expected)


if __name__ == '__main__':
    unittest.main()
