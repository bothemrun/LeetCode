class Solution {
  public int closestToTarget(int[] arr, int target) {
    int ans = Integer.MAX_VALUE;
    // all the values of subarrays that end in the previous number
    Set<Integer> prev = new HashSet<>();

    for (final int num : arr) {
      HashSet<Integer> next = new HashSet<>(Arrays.asList(num));
      // Extend each subarray that ends in the previous number. Due to
      // monotonicity of the AND operation, the size of `next` will be at most
      // Integer.bitCount(num) + 1.
      for (final int val : prev)
        next.add(val & num);
      for (final int val : next)
        ans = Math.min(ans, Math.abs(target - val));
      prev = next;
    }

    return ans;
  }
}
