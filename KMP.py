





'''
not finish
'''



def getNext(s:str):
  if (len(s) <= 0): return None
  s = list(s)
  next = []
  next.append(0)
  for i in range(1, len(s) - 1, 1):
    j = next[i - 1] 
    while j > 0 and s[j] != s[i]: j = next[j]
    next.append(j + 1)
    i += 1
    j += 1
  return next

s = 'aabaaf'

print(getNext(s))