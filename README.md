
# To Verify Manifest
```sh
    jar xf target/wc-cli-1.0.jar META-INF/MANIFEST.MF
    cat META-INF/MANIFEST.MF
```

# Packaging

- added the **maven-assembly-plugin** to generate the jar with dependency
- To generate a jar 
    > mvn clean package
- Wrote a script(wcli.sh) to run this jar
- make this script executable
    > chmod +x wcli.sh
- Open a new command line and run the scripts 
  1. Command to count bytes in file
     ``wcli -m test.txt`` ✅
  2. Command to count lines in file
     ``wcli -l test.txt`` ✅
  3. Command to count characters in file
     ``wcli -c test.txt`` ✅
  4. Command to count words in file
     ``wcli -w test.txt`` ✅

# Learnings
- System.in is a blocking read, to read from console. So do check if we are getting input from console or not.(Reference: ``FileReaderUtils.java:savePipedInput``)

# Possible Enhancement
- allow merged options (``wcli -lc text.txt``) or multiple options (``wcli -l -c test.txt``)

# Hard Time
- I had a hard time setting up maven project (not an java expert) 😆, specially the packaging stuff and understanding role of Manifest file for a jar
- So, i wrote an article 