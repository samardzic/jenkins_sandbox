Manage Jenkins -> Script Console
----------------------------------
System.clearProperty("hudson.model.DirectoryBrowserSupport.CSP");
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox allow-same-origin allow-scripts; default-src *; style-src * 'unsafe-inline'; script-src * 'unsafe-inline' 'unsafe-eval' ; font-src * data: ");


