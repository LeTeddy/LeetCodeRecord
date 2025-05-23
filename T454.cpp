#include <vector>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    int fourSumCount(vector<int> &nums1, vector<int> &nums2, vector<int> &nums3, vector<int> &nums4)
    {
        int res = 0;
        // 这里还就只能两个两个的遍历 不然 遍历一个生成一个新的哈希表的话，最糟糕的就是n^4的复杂度，两个两个遍历，最糟糕是n^2的复杂度
        // unordered_map<int,vector<int>> map1;//题目只要数量，所以不用存下标
        unordered_map<int, int> map1;
        // for(int i = 0;i < nums1.size();i++){
        //     for(int j = 0;j < nums2.size();j++){
        //         map1[nums1.at(i) + nums2.at(j)]++;
        //     }
        // }
        // 那样写太low了
        for (auto a : nums1)
        {
            for (auto b : nums2)
            {
                map1[a + b]++;
            }
        }
        for (auto c : nums3){
            for(auto d : nums4){
                res += map1[0 - c - d];
            }
        }
        return res;
    }
};

int main(){
    Solution s = Solution();
    vector<int> nums1 = {1,2};
    vector<int> nums2 = {-2,-1};
    vector<int> nums3 = {-1,2};
    vector<int> nums4 = {0,2};
    int res = s.fourSumCount(nums1,nums2,nums3,nums4);
    return 0;
}