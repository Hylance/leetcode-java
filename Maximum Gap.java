public int maximumGap (int[] num) {
	if (num == null || num.length < 2) {
		return 0;
	}
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	for (int value : num) {
		min = Math.min(min, value);
		max = Math.max(max, value);
	}
	int gap = (int)Math.ceil((double)(max - min) / (num.length - 1));
	int[] minNums = new int[num.length - 1];
	int[] maxNums = new int[num.length - 1];
	Arrays.fill(minNums, Integer.MAX_VALUE);
	Arrays.fill(maxNums, Integer.MIN_VALUE);
	for (int value : num) {
		if(value != min && value != max) {
			int i = (value - min) / gap;
			minNums[i] = Math.min(minNums[i], value);
			maxNums[i] = Math.max(maxNums[i], value);
		}
	}
	int maxGap = Integer.MIN_VALUE;
	int preMax = min;
	for (int i = 0; i < num.length - 1; i++) {
		if (minNums[i] != Integer.MAX_VALUE && maxNums[i] != Integer.MIN_VALUE) {
			maxGap = Math.max(maxGap, minNums[i] - preMax);
			preMax = maxNums[i];
		}
	}
	maxGap = Math.max(maxGap, max - preMax);
	return maxGap;
}

