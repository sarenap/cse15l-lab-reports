# Lab report 3: Researching Commands
The grep command is used to search for patterns in text files
grep [OPTIONS] PATTERN [FILE...]

4 options to grep:
1. **grep -i: Perform a case-insensitive search.
- *Example 1: search for the pattern "french". shows results for the word french capital or lowercase.
- Useful to find patterns despite grammar or capitalizing typos
- ![image](https://user-images.githubusercontent.com/122493371/218358035-112acbef-f0cd-40a4-bf4d-08228872a4ff.png)
```
grep -i french written_2/travel_guides/berlitz2/Paris-WhereToGo.txt

```
- *Example 2: search for pattern "INsiDE"
- ![image](https://user-images.githubusercontent.com/122493371/218358667-3a5ddb19-2a87-4a50-9108-fb5634eda69c.png)
```
grep -i INsiDE written_2/travel_guides/berlitz2/Paris-WhereToGo.txt

```

2. **grep -rl: search for specific pattern recursively (r). ONLY display the path of files that match pattern (l)
- useful when we only want to see the filepath with the matching pattern. 
- useful to search for substring of words too.
- displaying all matching file contents takes too much screen space (grep -r 'pattern')
- *Example 1: search for pattern "Paris", only show  file paths with the match NOT contents
- ![image](https://user-images.githubusercontent.com/122493371/218359371-45293f67-e5b3-4b06-beaf-a2a8407d348f.png)
```
grep -rl Paris

```
- *Example 2: search for pattern "ri", show only file paths with the match.
- ![image](https://user-images.githubusercontent.com/122493371/218360891-a7cc8d81-dc05-4128-8e7c-3c8737252ca2.png)
```
grep -rl ri
```

3. **grep -c: show count of pattern matches in each file
- useful to count how many pattern matches appear in the file
- *Example 1: in this file, how many times does the pattern Chinese appear? shows 98 times
- ![image](https://user-images.githubusercontent.com/122493371/218360599-d2b79c2e-f4ea-4dcc-a4ca-c592d9ce9495.png)
```
grep -c Chinese written_2/travel_guides/berlitz2/China-WhereToGo.txt

```
- *Example 2: in this file, how many times does pattern pizza appear? shows 0 times since no matches
- ![image](https://user-images.githubusercontent.com/122493371/218361211-103adedd-d3e1-4cf5-bdcb-4574df310988.png)
```
grep -c pizza written_2/travel_guides/berlitz1/WhatToItaly.txt

```

4. **grep -n: Display the line numbers of the matching lines. 
- useful to see exatcly which lines the pattern matches appear
- *Example 1: which lines have the pattern 'war'?
- ![image](https://user-images.githubusercontent.com/122493371/218362076-849a8184-d389-41a0-8ef9-f8c49213b687.png)
```
grep -n war written_2/travel_guides/berlitz1/WhatToItaly.txt

```

- *Example 2: which liens have the pattern 'Italy'?
- ![image](https://user-images.githubusercontent.com/122493371/218362255-7a9d1b57-644a-4c60-8462-1d10ce59cec6.png)
```
grep -n Italy written_2/travel_guides/berlitz1/WhatToItaly.txt

```

5. Citations: man grep command on bash, chat gpt https://chat.openai.com/chat/c4d0c758-08ca-4538-918d-921db277ea11
-![image](https://user-images.githubusercontent.com/122493371/218362379-2585bb5a-4662-4388-bcea-0e1bc2cd6ffc.png)




