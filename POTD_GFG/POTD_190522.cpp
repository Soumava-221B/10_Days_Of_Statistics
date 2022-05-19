#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

// } Driver Code Ends
class Solution
{
public:
    int transform(string A, string B)
    {

        if (A.size() != B.size())
            return -1;
        unordered_map<char, int> u1, u2;
        for (auto i : A)
            u1[i]++;
        for (auto i : B)
            u2[i]++;
        for (auto i : u1)
        {
            if (i.second != u2[i.first])
                return -1;
        }
        int n = A.size(), i = n - 1, j = n - 1, c = 0;
        while (i >= 0)
        {
            if (A[i] == B[j])
                j -= 1;
            else
                c += 1;
            i -= 1;
        }
        return c;
    }
};

// { Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string A, B;
        cin >> A >> B;
        Solution ob;
        cout << ob.transform(A, B) << endl;
    }
} // } Driver Code Ends