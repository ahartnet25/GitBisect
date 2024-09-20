# GitBisect
Git Bisect Maven Example

## Story
An error was discovered in production with the Calculator roundUp method. Using git bisect and maven test we can locate the version that introduced the error. This passing/failure will be automated by passing a script bisectValidate.sh to the bisect command.

## Instructions
1. Create a junit test that will validate Calulator roundUp method. IE BugFinderTest

```sh
    package com.andy;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import org.junit.jupiter.api.Test;

    public class BugFinderTest {

        @Test
        void testRoundup() {
            Calculator calculator = new Calculator();
            assertEquals(11, calculator.roundUp(10.711));
        }

    }
```
2. Stash BugFinderTest with the name "BugFinderStash". This name will be used in a script to apply the stash since we don't want to check it in. We also want to use it on prior versions if possible.

3. Create a script that returns success 0 or any other number for failure. IE bisectValidate is in the project's home directory. The script will apply our stash (the test code), try to build the project, and if that is successful, it will run the test that we applied from the stash. The return values from the script will be used by git bisect to find the version that introduced the error.

```sh
#!/bin/bash

export JAVA_HOME="C:/MyStuff/JavaVersions/jdk-17.0.2"
export PATH=$JAVA_HOME/bin:$PATH

STASH_NAME="BugFinderStash"

# Step 1: Find the stash index by name
STASH_INDEX=$(git stash list | grep "$STASH_NAME" | awk -F: '{print $1}' | tr -d ' ')

# Check if the stash was found
if [ -z "$STASH_INDEX" ]; then
  echo "Stash named '$STASH_NAME' not found."
  exit 1
fi

# Step 2: Apply the stash
echo "Applying stash: $STASH_INDEX"
git stash apply "$STASH_INDEX"

# Step 3: Run Maven tests
echo "Running Maven tests..."

mvn clean install -DskipTests
test_result=$?
#If it doesn't compile make it a success since that method might not have existed yet
if [ $test_result -ne 0 ]; then
  echo "Compile failed."
  test_result=0
else
    mvn test
    test_result=$?

    if [ $test_result -ne 0 ]; then
        echo "Tests failed."
    else
        echo "Tests passed."
    fi 
fi

# Step 4 Unapply the stash if the test failed
echo "Unapply stash."
git reset --hard


# Exit with the result of the test
exit $test_result
```

4. Start bisect in a git bash shell
```sh
git bisect start
```

5. Start bisect in a git bash shell
```sh
git bisect start
```

6. Flag the current commit as bad since it has the know error
```sh
git bisect bad
```

7. Flag the earliest commit as good. If possible be more precise. IE the sha of the fist commit
```sh
git bisect good 0bb45f3
```

8. Run bisect using our test script
```sh
git bisect run ./bisectValidate.sh
```

9. Once bisect is finished running it will point to the commit where the error was introduced
```sh
Tests failed.
Unapply stash.
HEAD is now at 3ab595e Added power and an error
3ab595e58600e443ef901521fca356764821f0ef is the first bad commit
commit 3ab595e58600e443ef901521fca356764821f0ef
Author: Andrew P. Hartnett <ahartnet@nycm.com>
Date:   Fri Sep 20 09:39:23 2024 -0400

    Added power and an error

```