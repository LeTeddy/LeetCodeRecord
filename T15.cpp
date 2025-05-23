/*
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

    注  意：答案中不可以包含重复的三元组。

    示例 1：

    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    解释：
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
    不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
    注意，输出的顺序和三元组的顺序并不重要。
    示例 2：

    输入：nums = [0,1,1]
    输出：[]
    解释：唯一可能的三元组和不为 0 。
    示例 3：

    输入：nums = [0,0,0]
    输出：[[0,0,0]]
    解释：唯一可能的三元组和为 0 。
 */

#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;
class Solution
{
public:
    // vector<vector<int>> threeSum(vector<int> &nums)
    // {
    //     vector<vector<int>> res;
    //     // 用454题的思路，先合并两数之和，然后看0-第三个数是否存在
    //     // 定义map用来存和和下标吧
    //     unordered_map<int, vector<int[2]>> map;
    //     for (int i = 0; i < nums.size(); i++)
    //     {
    //         for (int j = i + 1; j < nums.size(); j++)
    //         {
    //             int indexs[2] = {i, j};
    //             map[nums.at(i) + nums.at(j)].push_back(indexs);
    //         }
    //     }
    //     for (int i = 0; i < nums.size(); i++)
    //     {
    //         int target = 0 - nums.at(i);
    //         if (map.find(target) != map.end())
    //         {
    //             for (auto vec : map[target])
    //             {
    //                 if (*vec != i && *(vec + 1) != i)
    //                 {
    //                     vector<int> r = {vec[0],vec[1],i};
    //                     res.push_back(r);
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }
    // 那样不行，首先 vector里面不能存放固定大小的数组
    // 其次这样会存在重复
    // 这里要用双指针法
    // 双指针法要排序，我不想写，我去用java了
    // std::sort方法可以排序哦 导入#include <algorithm>
    // 那再实现一下C++版
    vector<vector<int>> threeSum(vector<int> &nums)
    {
        vector<vector<int>> res;
        int len = nums.size();
        if (len < 3)
        {
            return res;
        }
        sort(nums.begin(), nums.end());
        if (nums[0] > 0)
        {
            return res;
        }
        for (int i = 0; i < len; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            int left = i + 1, right = len - 1;
            int sum = nums[i] + nums[left] + nums[right];
            if (sum > 0)
            {
                right--;
            }
            else if (sum < 0)
            {
                left++;
            }
            else
            {
                vector<int> r;
                r.push_back(nums[i]);
                r.push_back(nums[left]);
                r.push_back(nums[right]);
                res.push_back(r);
                while (left < right && nums[right] == nums[right - 1])
                {
                    right--;
                }
                while (left < right && nums[left] == nums[left + 1])
                {
                    left++;
                }
                right--;
                left++;
            }
        }
        return res;
    }
};