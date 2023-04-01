// 获取当前时间(xxxx-xx-xx)
export function getCurDate()
{
	let now = new Date();
	let year = now.getFullYear();
	let month = now.getMonth();
	let day = now.getDate();
	let month_str = month < 10 ? "0" + String(month): String(month);
	let day_str = day < 10 ? "0" + day: day;
	return year + "-" + month_str + "-" + day_str;
}

//sessionStorage中存储一个JSON对象
export function setSessionStorage(key:any, value:any)
{
	sessionStorage.setItem(key, JSON.stringify(value));
}

export function getSessionStorage(key:any)
{
	var str = sessionStorage.getItem(key);
	if(str == '' || str == null || str == 'null' || str == undefined)
	{
		return null;
	}
	else
	{
		return JSON.parse(str);
	}
}

// 从seesionStorage中移除一个JSON对象
export function removeSessionStorage(key:any)
{
	sessionStorage.removeItem(key);
}

// 向localStorage中存储一个JSON对象
export function setLocalStorage(key:any, value:any)
{
	localStorage.setItem(key, JSON.stringify(value));
}

// 从localStorage中获取一个JSON对象(取不到时返回null)
export function getLocalStorage(key:any)
{
	var str = localStorage.getItem(key);
	if(str == '' || str == null || str == 'null' || str == undefined)
	{
		return null;
	}
	else
	{
		return JSON.parse(str);
	}

}

// 从localStorage中移除一个对象
export function removeLocalStorage(key:any)
{
	localStorage.removeItem(key);
}