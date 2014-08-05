package basicMethod;

public class Divide_and_Conquer {

	public static double entropy(double... pi) {
		double entropy = 0;

		for (int i = 0; i < pi.length; i++) {

			entropy += -pi[i] * Math.log(pi[i]);
			System.out.println("p" + i + " = " + pi[i] + "log = "
					+ Math.log(pi[i]));

		}

		entropy = entropy / Math.log(2);

		return entropy;
	}

	public static double info(int... numberOfValues) {
		double info = 0;
		double sum = 0;

		for (int i = 0; i < numberOfValues.length; i++) {
			if (numberOfValues[i] == 0) {
				return 0;
			}
		}

		for (int i = 0; i < numberOfValues.length; i++) {

			info += -(double) numberOfValues[i] * Math.log(numberOfValues[i]);
			sum += (double) numberOfValues[i];
		}

		info = (info + sum * Math.log(sum)) / (sum * Math.log(2));

		// info = info/(sum*Math.log(2));

		return info;
	}

	public static double info(int[]... numberOfValuesBranchs) {

		double sum = 0;

		double info = 0;

		double[] subSum = new double[numberOfValuesBranchs.length];

		for (int i = 0; i < numberOfValuesBranchs.length; i++) {

			double subsum = 0;
			for (int j = 0; j < numberOfValuesBranchs[i].length; j++) {

				sum += numberOfValuesBranchs[i][j];
				subsum += numberOfValuesBranchs[i][j];
			}
			subSum[i] = subsum;

		}

		for (int i = 0; i < numberOfValuesBranchs.length; i++) {

			info += subSum[i] * info(numberOfValuesBranchs[i]);

		}

		info /= sum;

		return info;
	}

	public static double gain(int[]... numberOfValuesBranchs) {
		double gain = 0;

		int numberOfClasses = numberOfValuesBranchs[0].length;
		int[] infoOver = new int[numberOfClasses];
		for (int i = 0; i < numberOfClasses; i++) {
			for (int j = 0; j < numberOfValuesBranchs.length; j++) {

				infoOver[i] += numberOfValuesBranchs[j][i];

			}

		}

		gain = info(infoOver) - info(numberOfValuesBranchs);

		return gain;

	}

	public static double split_info(int[]... numberOfValuesBranchs) {
		double spInfo = 0;

		int[] sumOfInstances = new int[numberOfValuesBranchs.length];
		
		for(int i=0; i<numberOfValuesBranchs.length; i++){
			
			sumOfInstances[i] = useful.Cal.arraySum(numberOfValuesBranchs[i]);
			
		}

		spInfo = info(sumOfInstances);
		

		return spInfo;
	}

	public static double gain_ration(int[]... numberOfValuesBranchs){
		double gRation = 0;
		
		gRation = gain(numberOfValuesBranchs)/split_info(numberOfValuesBranchs);
		
		return gRation;
	}
	
	public static void main(String[] args) {

		System.out.println(split_info(new int[] { 2, 3 }, new int[] { 4, 0 },
				new int[]{3,2}));

		System.out.println(gain_ration(new int[] { 2, 3 }, new int[] { 4, 0 },
				new int[]{3,2}));
		
	}

}
