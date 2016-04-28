Velocity Tags
=============

`velocity-tags` is a collection of useful Apache Velocity custom directives that I
have created and used in multiple projects over time.

## Available Directives

* `atomicNum` - writes the value of AtomicInteger or AtomicLong
* `date` - converts given epoch millis to Date and displays it as String
* `encodeURIComponent` - Encodes the given value as URI encoded component
* `escapeHTML` - writes a HTML escaped version of the given value
* `gson` - writes the Gson based JSON value of the given object
* `mapGet` - writes the value of the provided key from the given Map instance
* `pageURI` - strips off the scheme and domain part from a URL before writing it
* `readableByteSize` - convert the given number to a readable byte-size string
* `readableTime` - convert the given millis to a readable time-based string

## License

```
 velocity-tags - Collection of useful Apache Velocity directives
 Copyright (c) 2010-2016, Sandeep Gupta
 
 http://sangupta.com/projects/velocity-tags
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
 		http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```
