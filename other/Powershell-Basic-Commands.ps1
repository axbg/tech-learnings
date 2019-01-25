#Clean console
cls
clear



#Get Services
Get-Service 

#Get Running services
Get-Service | Where-Object Status -EQ 'Running'

#Get Name, Displayname and Status of  Stopped services and export them to a csv file
Get-Service | Where-Object Status -EQ 'Stopped' | Select-Object Status, Name, Displayname | Export-Csv -Path C:\Users\a.bisag\Desktop\stopped.csv 

#Display Powershell Version
$PSVersionTable

#Display available cmdlets
Get-Command




#Files control
#Append content to a file
Add-Content -Path "give path" -Value "value here"

#Set content of a file
Set-Content -Path "give path" -Value "value here"

#Write output of a command into a file
##it can be replaced with >
Out-File -FilePath "here file path" -





#Conect wi#th RDP to a virtual machine
mstsc /v:"machine's public ip/ loadbalancer":"port"
