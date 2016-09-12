#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <math.h>
#include <string.h>
#include <algorithm>

using namespace std;

char lastLetter(string word) {
    return word[word.length() - 1];
}

char firstLetter(string word) {
    return word[0];
}

int findLongestWordChain(vector<string> words);
int findLongestWordChain(int count, vector<string> words);

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {

        stringstream ss(line);
        string s;
        vector<string> v;

        while (getline(ss, s, ',')) {
            v.push_back(s);
        }

        int longestWordChain = findLongestWordChain(v);
        if(longestWordChain == 1) {
            cout << "None";
        }
        else {
            cout << longestWordChain;
        }
        cout << endl;

    }
    return 0;
}

//called first
//finds all possible word chains for each word by swapping
int findLongestWordChain(vector<string> words) {

    int largestCount = findLongestWordChain(1, words);;

    for(int i = 1; i < words.size(); i++) {
        vector<string> swappedI = words;
        iter_swap(swappedI.begin(), swappedI.begin() + i); //let every word be first

        int countI = findLongestWordChain(1, swappedI);
        if(largestCount < countI)
            largestCount = countI;
    }

    return largestCount;
}

//Function compares the first word in list to all the other words and finds possible chain word
//if chain word is found, new list is made with the chain word in front and recursively finds chain words
int findLongestWordChain(int count, vector<string> words) {

    //base case
    if(words.size() == 2)
        return (lastLetter(words[0]) == firstLetter(words[1])) ? count + 1 : count;

    //holds longest word chain for words
    int largestCount = count;

    for(int i = 1; i < words.size(); i++) {
        //found a chain
        if(lastLetter(words[0]) == firstLetter(words[i])) {

            //make new list of words
            vector<string> newWords;
            newWords.push_back(words[i]);
            for(int j = 1; j < i; j++)
                newWords.push_back(words[j]);

            for(int k = i + 1; k < words.size(); k++)
                newWords.push_back(words[k]);


            int countI = findLongestWordChain(count + 1, newWords);
            if(largestCount < countI)
                largestCount = countI;
        }
    }

    return largestCount;
}