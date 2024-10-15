#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

class Solution:
    
    #Complete this fuction
    #Function to count the number of subarrays which adds to the given sum.
    def subArraySum(self,arr, tar):
        preSum = {0 : 1}
        
        prefixSum = 0
        count = 0
        
        for num in arr:
            prefixSum += num
            
            remove = prefixSum - tar
            if remove in preSum:
                count += preSum[remove]
            
            preSum[prefixSum] = preSum.get(prefixSum, 0) + 1
        
        return count
        

#{ 
 # Driver Code Starts.
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while t > 0:
        arr = list(map(int, input().split()))
        tar= int(input())
        ob = Solution()
        res = ob.subArraySum(arr,tar)
        print(res)
        # print("~")
        t -= 1


# } Driver Code Ends