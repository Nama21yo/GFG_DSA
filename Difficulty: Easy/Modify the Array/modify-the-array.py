#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

class Solution:  
    def modifyAndRearrangeArr(self, arr):  
        # Step 1: Modify the array  
        i = 0  
        while i < len(arr) - 1:  
            if arr[i] == arr[i + 1] and arr[i] != 0:  
                arr[i] *= 2  # Double the current number  
                arr[i + 1] = 0  # Set the next number to 0  
                i += 1  # Skip the next number since it's now 0  
            i += 1  
        
        # Step 2: Rearrange to move all zeros to the end  
        non_zero_elements = [num for num in arr if num != 0]  
        zero_count = arr.count(0)  
        
        # Combine non-zero elements with zeros at the end  
        modified_array = non_zero_elements + [0] * zero_count  
        
        return modified_array  




#{ 
 # Driver Code Starts.
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while t > 0:
        arr = list(map(int, input().split()))
        ob = Solution()
        ans = ob.modifyAndRearrangeArr(arr)
        print(*ans)
        print("~")
        t -= 1


# } Driver Code Ends