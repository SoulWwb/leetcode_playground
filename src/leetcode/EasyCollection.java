package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EasyCollection {

    public void printArr(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    // 1.
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int bi = nums.length - 1;
        int i, j;
        for (i = 0; i < bi; i++) {
            if (nums[i] == nums[i + 1]) {
                for (j = 1; j < bi - i; j++) {
                    nums[i + j] = nums[i + j + 1];
                }
                bi--;
                i--;
            }
        }
        return bi + 1;
    }

    // 2. 买卖股票的最佳时机 II
    public int maxProfit(int[] prices) {
        int lowIndex = 0;
        int highIndex = 0;
        int i, sum = 0;
        boolean flag = false;
        for (i = 1; i < prices.length; i++) {
            if (prices[i] < prices[lowIndex] && i + 1 < prices.length && prices[i + 1] > prices[i]) {
                lowIndex = i;
                highIndex = i;
            }

            if (prices[i] > prices[highIndex]) {
                if (i + 1 == prices.length) {
                    sum += prices[i] - prices[lowIndex];
                    break;
                } else if (prices[i + 1] < prices[i]) {
                    sum += prices[i] - prices[lowIndex];
                    lowIndex = i + 1;
                    highIndex = i + 1;
                }

            }

        }
        return sum;
    }

    // 3. 旋转数组
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) return;
        int needToMove, i;
        needToMove = k % nums.length;
        if (needToMove != 0) {
            int[] tempArr = new int[nums.length];
            int j = nums.length - needToMove;
            for (i = 0; j < nums.length; i++, j++) {
                tempArr[i] = nums[j];
            }
            for (i = needToMove; i < nums.length; i++) {
                tempArr[i] = nums[i - needToMove];
            }
            System.arraycopy(tempArr, 0, nums, 0, nums.length);
        }
    }

    // 4.存在重复
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        int i;
        Map<Integer, Integer> map = new HashMap<>();
        for (i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    // 5.只出现一次的数字
    public int singleNumber(int[] nums) {
        int i;
        Arrays.sort(nums);
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) i++;
            else break;
        }
        return nums[i];
    }


}

