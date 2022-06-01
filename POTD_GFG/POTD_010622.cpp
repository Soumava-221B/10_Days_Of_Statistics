// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution
{
public:
    void getAns(int np, int n, int box1, int box2, int box3, vector<int> &ans, int &cnt)
    {
        if (ans.size() || np == 0)
            return;

        getAns(np - 1, n, box1, box3, box2, ans, cnt);

        if (++cnt == n)
        {
            ans.push_back(box1);
            ans.push_back(box3);
        }

        getAns(np - 1, n, box2, box1, box3, ans, cnt);
    }

    vector<int> shiftPile(int np, int n)
    {

        vector<int> ans;
        int cnt = 0;
        getAns(np, n, 1, 2, 3, ans, cnt);
        return ans;
    }
};

// { Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N, n;
        cin >> N >> n;

        Solution ob;
        vector<int> ans = ob.shiftPile(N, n);
        cout << ans[0] << " " << ans[1] << endl;
    }
    return 0;
} // } Driver Code Ends